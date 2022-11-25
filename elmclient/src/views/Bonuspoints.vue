<template>
	<div class="wrapper">
	    <Header name="我的积分" />
	    <div class="card">
	        <div class="card-body">
	            <div class="row">
	                <div class="col-6">积分：0</div>
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
	 			virtualWallet: {}
			}
	 	},
	}
</script>

<style>
</style>
