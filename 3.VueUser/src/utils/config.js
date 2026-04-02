const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '培训信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'培训信息',
							url:'/index/peixunxinxiList'
						},
					]
				},
				{
					name: '绩效标准管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'绩效标准',
							url:'/index/jixiaobiaozhunList'
						},
					]
				},
				{
					name: '招聘信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'招聘信息',
							url:'/index/zhaopinxinxiList'
						},
					]
				},
				{
					name: '薪酬标准管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'薪酬标准',
							url:'/index/xinchoubiaozhunList'
						},
					]
				},
				{
					name: '公告信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'公告信息',
							url:'/index/newsList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot的人事管理系统"
        } 
    }
}
export default config
