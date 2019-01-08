function register_init(){
	var form = {
          name: '',
          pass: '',
          module: [
					{moduleName:'模块a',powerList:[{powerName:'可读',power:true},{powerName:'可写',power:true}]},
					{moduleName:'模块b',powerList:[{powerName:'可读',power:true},{powerName:'可写',power:true}]},
					{moduleName:'模块c',powerList:[{powerName:'可读',power:true},{powerName:'可写',power:true}]}
				]
          }
	var register = new Vue({
		el:'#register',
		data:function(){
			return{
				form:form
			}
		},
		methods:{
			onSubmit:function() {
        		console.log('submit!');
      		},
      		changePower: function(module,index){
      			module.powerList[index].power = !module.powerList[index].power;
      		}
		}
	})
	return register;
}