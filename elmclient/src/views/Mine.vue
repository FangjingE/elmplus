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

<style scoped>
.wrapper {
    width: 100%;
	height: 100%;
	background-image: linear-gradient(to top, rgba(255, 0, 0, 0), rgb(59, 176, 246));
}

.card {
    display: flex;
    align-items: center;
    justify-content: space-between;
    
    height: 9vw;
    
    font-size: 3.5vw;
    color: white;
    background-color: #359cff;
    margin: 2vw 3vw 0 3vw;
    
    border-radius: 10px 10px 0 0;
}

</style>
