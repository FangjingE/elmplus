<template>
	<div class="wrapper">
		<!-- header部分 -->
		<header>
			<p>提现</p>
		</header>
		<!-- 表单部分 -->
		<ul class="form-box">
			<li>
				<div class="title">
					提现金额：
				</div>
				<div class="content">
					<input type="text" v-model="amount" placeholder="提现金额">
				</div>
			</li>
		</ul>
		<div class="button-debit">
			<button @click="debit">确定</button>
		</div>
     </div>
</template>

<script>
	export default {
		name: 'Debit',
		data() {
			return {
                virtualwallet :{},
				amount: {},

			}
		},

		created() {
			this.user = this.$getSessionStorage('user');
			this.$axios.post('VirtualWalletController/getWalletbyuserId', this.$qs.stringify({
				userid: this.user.userId
			})).then(response => {
				this.virtualwallet = response.data;
			}).catch(error => {
				console.error(error);
			});
			
		},
		methods: {
			debit() {
				if (this.virtualwallet.balance < this.amount) {
					alert('余额不足！');
					return;
				}
				this.$axios.post('VirtualWalletController/debit', this.$qs.stringify({

						userId: this.user.userId,
						amount: this.amount,
					}
				)).then(
				alert('提现成功！'),
				this.$router.go(-1)
			).catch(error => {
				console.error(error)
			});

		}
	},
	}
	// if(this.virtualwallet.balance<this.orders.orderTotal)
	// {
	// 	alert('余额不足！');
	// 	return;
	// }

	// this.$axios.post('VirtualWalletController/debit', this.$qs.stringify({

	// 	userId: this.user.userId,
	// 	amount: this.orders.orderTotal,

	// 
</script>

<style>
</style>
