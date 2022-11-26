<template>
	<div class="wrapper">
	<header>
		<p>积分流水</p>
	</header>
	<ul class="transcation">
		<li v-for="item in transcationArr" >
			<div class="trancation-info">
				<p>
					{{item}}
				</p>
			</div>
		</li>
	</ul>
	</div>
</template>

<script>
	export default{
		name:'Bonuspointstranscation',
		data(){
			return {
			transcationArr:[],
			}
		},
	created(){

		this.user = this.$getSessionStorage('user');
		
		this.$axios.post('BonuspointsController/listtransactionbyid', this.$qs.stringify({
			userid: this.user.userId
		})).then(response => {
			let result = response.data;
			console.log(result);
			this.transcationArr = result;
			
		}).catch(error => {
			console.error(error);
		});
	}
	}
</script>

<style>
</style>
