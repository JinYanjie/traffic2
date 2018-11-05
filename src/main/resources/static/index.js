var index_tabs;
$(function() {
    index_tabs = $('#index_tabs').tabs({
        fit : true,
        border : false
    });
})
function treeNodeClick(node){
    console.log(node);
    if (node.attributes && node.attributes.url) {
        var url=node.attributes.url;
        addTab({
            url : url,
            title : node.text,
            iconCls : node.iconCls
        });
    }
}
function addTab(params) {
		var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
		var t = $('#index_tabs');
		var opts = {
			title : params.title,
			closable : true,
			iconCls : params.iconCls,
			content : iframe,
			border : false,
			fit : true
		};
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
			var current_tab = $('#index_tabs').tabs('getSelected');
			$('#index_tabs').tabs('update',{
			   tab:current_tab,
			   options : {
			     content : iframe,
			   }
			});
			parent.$.messager.progress('close');
		} else {
			t.tabs('add', opts);
		}
	}
