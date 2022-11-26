<template>
    <div class="wrapper">
        <Header>
			<p>我的钱包</p>
		</Header>
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-6">余额：{{virtualWallet.balance}}</div>
                </div>
            </div>
        </div>
		<div class="debit-button">
			<button @click="todebit">提现</button>
		</div>
		<div class="credit-button">
			<button @click="tocredit">充值</button>
		</div>
		<div class="credit-button">
			<button @click="checktranscation">查看流水</button>
		</div>
    </div>
</template>
<!-- VirtualWallet.balance -->
<script>

export default {
    name: "Wallet",
	data() {
			return {
	// 			userId: this.$route.query.userId,
	 			virtualWallet: {}
			}
	 	},
     created() {
         this.user = this.$getSessionStorage('user');
		 this.$axios.post('VirtualWalletController/getWalletbyuserId', this.$qs.stringify({
		 userid: this.user.userId,
		 })).then(response => {
		   this.virtualWallet = response.data;
		   // this.$setSessionStorage('virtualWallet', virtualWallet);
		  // console.log(this.VirtualWallet);
		   }).catch(error => {
		        console.error(error);
		    });
},
     methods:{
		 todebit(){
         this.$router.push({
         	path: '/debit',
         });
			 
		 },
		 tocredit(){
         this.$router.push({
         	path: '/credit',
         });
			 
		 },
		 checktranscation(){
			 this.$router.push({
			 	path: '/transcation',
			 });
		 }
	 }


}
</script>

<style scoped>
.wrapper {
    width: 100%;
}

.card {
    height: 10vh;
    width: 92%;
    margin-left: 4%;
    margin-top: 15vh;
    font-size: 4vw;
}

.card div {
    /* width: 45%; */
}
</style>