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
                            <el-menu-item v-for="subitem in menu_item.subitems" :index="subitem.id" :key="subitem.id" @click="$emit(\'menu-click\', subitem)">\
                                <i class="el-icon-caret-right"></i> {{subitem.name}}\
                            </el-menu-item>\
                        </el-submenu>\
                    </el-menu>\
                '
    },
    component_data: 
    [
        {
            id: "meanu-a",
            name: '操作菜单a',
            icon: 'el-icon-location',
            subitems: [
                {id: "meanu-a-1", name: "子菜单1", url: ""},
                {id: "meanu-a-2", name: "子菜单2", url: ""}
            ]
        },
        {
            id: "meanu-b",
            name: '操作菜单b',
            icon: 'el-icon-setting',
            subitems: [
                {id: "meanu-b-1", name: "子菜单3", url: ""},
                {id: "meanu-b-2", name: "子菜单4", url: ""}
            ]
        }
    ]
};

var data_from_db = [
    {id: "meanu-a-1", name: "子菜单1", url: "", parent_id: "meanu-a", parent_name"操作菜单a"},
    {id: "meanu-a-2", name: "子菜单2", url: "", parent_id: "meanu-a", parent_name"操作菜单a"},
    {id: "meanu-b-1", name: "子菜单3", url: "", parent_id: "meanu-b", parent_name"操作菜单b"},
    {id: "meanu-b-2", name: "子菜单4", url: "", parent_id: "meanu-b", parent_name"操作菜单b"}
];