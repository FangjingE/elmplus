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
	}
</script>

<style scoped>
.wrapper {
    width: 100%;
	height: 100%;
	background-image: linear-gradient(to top, rgba(255, 0, 0, 0), rgb(59, 176, 246));
}
</style>
