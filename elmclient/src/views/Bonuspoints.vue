<template>
	<div class="wrapper">
	    <Header name="我的积分" />
	    <div class="card">
	        <div class="card-body">
	            <div class="row">
	                <div class="col-6">积分余额：{{bonuspoints.balance}}</div>
	            </div>
	        </div>
	    </div>
		
	</div>
</template>

<script>
	export default {
	name: "Bonuspoints",
	data() {
			return {
	// 			userId: this.$route.query.userId,
	 			bonuspoints: {}
			}
	 	},
		created() {
		         this.user = this.$getSessionStorage('user');
				 this.$axios.post('BonuspointsController/getBonuspointsbyuserId', this.$qs.stringify({
				 userid: this.user.userId,
				 })).then(response => {
				   this.bonuspoints = response.data;
				   // this.$setSessionStorage('virtualWallet', virtualWallet);
				  // console.log(this.VirtualWallet);
				   }).catch(error => {
				        console.error(error);
				    });
		},
	}
</script>

<style>
</style>
