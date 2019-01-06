var nav_menu = {
    component_name: "c-nav-menu",
    component_attr: {
        props: ["menu_display"],
        data: function() {
            return {
                menu_items: nav_menu.component_data
            };
        },
        template: ' <el-menu\
                        class="el-menu-vertical-demo"\
                        background-color="#545c64"\
                        text-color="#fff"\
                        :collapse="menu_display"\
                        active-text-color="#ffd04b">\
                        <el-submenu v-for="menu_item in menu_items" :key="menu_item.id" :index="menu_item.id">\
                            <template slot="title">\
                                <i :class="menu_item.icon"></i>\
                                <span>{{menu_item.name}}</span>\
                            </template>\
                            <el-menu-item v-for="subitem in menu_item.subitems" :index="subitem.menuid" :key="subitem.menuid" @click="$emit(\'menu-click\', subitem)">\
                                <i class="el-icon-caret-right"></i> {{subitem.menuname}}\
                            </el-menu-item>\
                        </el-submenu>\
                    </el-menu>\
                '
    },
    component_data: [
//        {
//            id: "meanu-a",
//            name: '操作菜单a',
//            icon: 'el-icon-location',
//            subitems: [
//                {menuid: "meanu-a-1", menuname: "子菜单1", menupath: ""},
//                {menuid: "meanu-a-2", menuname: "子菜单2", menupath: ""}
//            ]
//        }
    ],
    main_menu: {
    	map: {
    		id: "map",
    		name: '地图导航',
            icon: 'el-icon-location',
            subitems: []
    	},
    	basic: {
    		id: "basic",
    		name: '基础信息',
            icon: 'el-icon-location',
            subitems: []
    	},
    	system: {
    		id: "system",
    		name: '系统管理',
            icon: 'el-icon-setting',
            subitems: []
    	}
    },
    data_transform: function(db_format)  {
        var app_format = [];
        for(let i=0; i<db_format.length; i++) {
            let obj = db_format[i];
            if(app_format[obj.parent_id]) {
                
            }
        }
    }
};