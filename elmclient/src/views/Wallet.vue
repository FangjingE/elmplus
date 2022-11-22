<template>
    <div class="wrapper">
        <Header name="我的钱包" />
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-6">余额：{{balance}}</div>
                </div>
            </div>
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
	 			balance: {}
			}
	 	},
     created() {
         this.user = this.$getSessionStorage('user');
		 this.$axios.post('VirtualWalletController/getWalletbyuserId', this.$qs.stringify({
		 userid: this.user.userId,
		 })).then(response => {
		   this.VirtualWallet = response.data;
		   this.balance = this.VirtualWallet.balance
		  // console.log(this.VirtualWallet);
		   }).catch(error => {
		        console.error(error);
		    });
}
    //     this.$axios.post('VirtualWalletController/getBalance', this.$qs.stringify({
    //         userId: this.user.userId,
    //     })).then(response => {
    //         this.balance = response.data;
    //     }).catch(error => {
    //         console.error(error);
    //     });
    // },
    // methods: {

    // },
    // computed: {
    //     getCurreny() {
    //         this.$axios.post('CurrencyController/getCurrencyByUserId', this.$qs.stringify({
    //             userId: this.user.userId,
    //         })).then(response => {
    //             this.curreny = response.data;
    //             for (let index in this.currency) {
    //                 console.log(this.currency[index]);
    //             }
    //         }).catch(error => {
    //             console.error(error);
    //         })
    //     }
    // },

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