function app_init() {
	var app = new Vue({
        el: "#app",
        components: {
          "c-nav-menu": nav_menu.component_attr
        },
        data: {
        	loading: true,
            selected_tab_name: default_selected_tab_name,
            tabs_items: tabs_items,
            aside_height: document.documentElement.clientHeight,
            aside_width: "200px",
            menu_display: false,
            login_status: true,
            username: "",
            modifyPass: false,
            form: {
            	id:'',
                name: '',
                pass: ''
              },
            formLabelWidth: "120px"
        },
        methods: {
        	logout: function () {
        		document.location.href = "/safety/user/logout";
        	},
            shoe_hide_menu: function () {
                this.aside_width = this.menu_display ? "200px" : "65px";
                this.menu_display = !this.menu_display;
            },
            addTab: function(menuInfo) {
                if(this.isTabOpened(menuInfo.menuid)) {
                    this.selected_tab_name = menuInfo.menuid;
                    return;
                }
                var newTab = {
                    name: menuInfo.menuid,
                    title: menuInfo.menuname,
                    content: menuInfo.menupath,
                    icon: 'el-icon-tickets',
                    closable: true
                }
                this.tabs_items.push(newTab);
                this.selected_tab_name = newTab.name;
            },
            removeTab: function(tabName) {
                let tabs = this.tabs_items;
                this.tabs_items = tabs.filter(tab => tab.name !== tabName);
                if(tabName == this.selected_tab_name) {
                    this.selected_tab_name = default_selected_tab_name;
                }
            },
            isTabOpened: function(tabName) {
                for(let i=0; i<this.tabs_items.length; i++) {
                    if(tabName == this.tabs_items[i].name) {
                        return true;
                    }
                }
                return false;
            },
            modifyPassWord: function () {
            	var user_data = this.form;
            	$.ajax({
                    type : "post",
                    url : "/safety/user/modifyPassWord",
                    data : JSON.stringify(user_data),
                    contentType:'application/json;charset=utf-8',
                    async: false,
                    success : function(result) {
                       var rtlObj = eval('(' + result + ')');
                       if(rtlObj.result == "success") {
                    	   document.location.href = rtlObj.url;
                    	   this.modifyPass = false;
                       }
                    },
                    error : function(data) {
                    	console.log("error");
                    	$("body").html(data.responseText);
                    }
            	})
            },
        }
    });
    return app;
}