<template>
	<div class="wrapper">
	    <Header name="我的"/>
		<div>
		<p>我的id: {{user.userId}}</p>
		</div>
	    <div class="card">
	        <div class="card-body">
	            <div class="row">
					<router-link to="Wallet">我的钱包</router-link>
	            </div>
	        </div>
	    </div>
		<div class="card">
		    <div class="card-body">
		        <div class="row">
		           <router-link to="Bonuspoints">我的积分</router-link>
		        </div>
		    </div>
		</div>
	</div>
</template>

<script>
	export default {
		name: 'Mine',
		// data()
		// {
		// 	return null;
		// },
        created()
        {
         this.user=this.$getSessionStorage('user');
        },
		methods: {
			

			}
		}
		
</script>

<style>
</style>
