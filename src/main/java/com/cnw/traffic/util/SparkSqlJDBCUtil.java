package com.cnw.traffic.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 * 1、启动大数据平台HDFS
 * 2、启动Spark sbin目录中的./start-thriftserver.sh(单机模式) 或./start-thriftserver.sh --master <master-uri> (集群模式)
 * 3、web项目pom.xml中引入hive-jdbc 和hadoop-common
 * <dependency>
 * 			<groupId>org.apache.hive</groupId>
 * 			<artifactId>hive-jdbc</artifactId>
 * 			<version>1.2.1</version>
 * 		</dependency>
 * 		<dependency>
 * 			<groupId>org.apache.hadoop</groupId>
 * 			<artifactId>hadoop-common</artifactId>
 * 			<version>2.7.3</version>
 * 		</dependency>
 *
 */
public class SparkSqlJDBCUtil {

	public static void main(String[] args) throws SQLException{
		String url = "jdbc:hive2://bigdata01:10000/default";
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(url,"root","");
		Statement stmt = conn.createStatement();
		String sql = "SELECT hphm,tgsj,kk_lon_lat FROM t_cltgxx t where t.tgsj >'2017-03-24 09:22:22' and t.tgsj <'2018-10-03 12:23:00' and t.hphm='粤AL9786' order by tgsj";
		System.out.println("Running:"+sql);
		ResultSet res = stmt.executeQuery(sql);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		while(res.next()){
			System.out.println("hphm: "+res.getString(1)
					        +"  tgsj: "+df.format(res.getTimestamp(2))
							+"  kk_lon_lat: "+res.getString(3));
		}
		stmt.close();
		conn.close();
	}
}
