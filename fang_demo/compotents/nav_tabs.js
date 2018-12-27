var nav_tabs = {
    component_name: "c-nav-tabs",
    opend_tab_list: [],
    component_attr: {
        props: ["select_tab_name"],
        data: function() {
            return {
                tabs_items: nav_tabs.component_data
            };
        },
        template: ' <el-tabs v-model="select_tab_name" type="border-card" @tab-remove="removeTab">\
                        <el-tab-pane\
                            v-for="(tab, index) in tabs_items"\
                            :key="tab.name"\
                            :label="tab.title"\
                            :closable="tab.closable"\
                            :name="tab.name">\
                            <span slot="label"><i :class="tab.icon"></i> {{tab.title}}</span>\
                            <!-- <iframe :src="tab.content" style="width:100%;min-height:660px;border:none;"></iframe> -->\
                        </el-tab-pane>\
                    </el-tabs>\
                ',
        methods: {
            removeTab: function(targetName) {
                let tabs = this.tabs_items;
                this.tabs_items = tabs.filter(tab => tab.name !== targetName);
                nav_tabs.opend_tab_list = nav_tabs.opend_tab_list.filter(name => name !== targetName);
                nav_tabs.component_data = this.tabs_items;
                var tabInfo = {
                    closeTabName: targetName,
                    nextOpnTabName: "index"
                }
                this.$emit("remove-tab", tabInfo);
            }
        }
    },
    component_data:
    [
        {
            name: 'index',
            title: '主页',
            icon: 'el-icon-star-on',
            content: 'http://www.baidu.com',
            closable: false
        }
    ],
    addTab: function(targetName) {
        for(var i = 0; i < nav_tabs.opend_tab_list.length; i++) {
            if(targetName == nav_tabs.opend_tab_list[i]) {
                return;
            }
        }
        nav_tabs.opend_tab_list.push(targetName);
        var tabItem = {
            name: targetName,
            title: targetName,
            content: 'http://element-cn.eleme.io',
            icon: 'el-icon-tickets',
            closable: true
        }
        nav_tabs.component_data.push(tabItem);
    }
};