var nav_menu = {
    component_name: "nav-menu",
    component_attr: {
        props: ['menu_attr'],
        template: ' <el-submenu :index="menu_attr.id">\
                        <template slot="title">\
                            <i :class="menu_attr.icon"></i>\
                            <span>{{menu_attr.name}}</span>\
                        </template>\
                        <el-menu-item v-for="subitem in menu_attr.subitems" :index="subitem.id" :key="subitem.id">{{subitem.name}}</el-menu-item>\
                    </el-submenu>\
                '
    },
    component_data: [
        {
            id: "meanu-a",
            name: '操作菜单a',
            icon: 'el-icon-location',
            subitems: [
                {id: "meanu-a-1", name: "子菜单1"},
                {id: "meanu-a-2", name: "子菜单2"}
            ]
        },
        {
            id: "meanu-b",
            name: '操作菜单b',
            icon: 'el-icon-setting',
            subitems: [
                {id: "meanu-b-1", name: "子菜单3"},
                {id: "meanu-b-2", name: "子菜单4"}
            ]
        }
    ]
};