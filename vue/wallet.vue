<template>
    <div class="wrapper">
        <Header name="我的钱包" />
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-6">余额：{{currency.amount}}</div>
                    <div class="col-6">积分：0</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Header from '../components/Header.vue';
export default {
    name: "Wallet",
    data() {
        return {
            user: {},
            currency: {},
        }
    },
    created() {
        this.user = this.$getSessionStorage('user');

        this.$axios.post('CurrencyController/getCurrencyByUserId', this.$qs.stringify({
            userId: this.user.userId,
        })).then(response => {
            this.currency = response.data;
        }).catch(error => {
            console.error(error);
        });
    },
    methods: {

    },
    computed: {
        getCurreny() {
            this.$axios.post('CurrencyController/getCurrencyByUserId', this.$qs.stringify({
                userId: this.user.userId,
            })).then(response => {
                this.curreny = response.data;
                for (let index in this.currency) {
                    console.log(this.currency[index]);
                }
            }).catch(error => {
                console.error(error);
            })
        }
    },
    components: {
        Header,
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