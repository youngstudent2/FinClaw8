<template>
    <div >
        <dv-border-box13 style="height: 550px">
            <h2 style="padding-top: 30px; padding-bottom: 10px">利率池分配推荐</h2>
            <div style="display: flex; flex-direction: row; justify-content: center; width: 100%;">
                <h4 style="padding-top: 5px">请输入资金总额：</h4>
                <a-input prefix="￥" suffix="RMB" style="width: 150px" v-model="total" />
                <a-button type="primary" style="margin-left: 10px" @click="getAmount">推荐</a-button>
            </div>
            <div :style="backgroundStyle">
                <div style="padding-top: 245px; padding-left: 225px; position: absolute;
                            font-family: 'Verdana'; font-weight: bold; color: #eeeeee">
                    <p>类型：短期（1年内）<br>年利率：4.3%<br>占比：{{rateA * 100}}%<br>金额：{{amountA}}元</p>
                </div>
                <div style="padding-top: 165px; padding-left: 425px; position: absolute;
                            font-family: 'Verdana'; font-weight: bold; color: #444444">
                    <p>类型：中期（1至5年）<br>年利率：4.7%<br>占比：{{rateB * 100}}%<br>金额：{{amountB}}元</p>
                </div>
                <div style="padding-top: 260px; padding-left: 730px; position: absolute;
                            font-family: 'Verdana'; font-weight: bold; color: #999999">
                    <p>类型：长期（5年以上）<br>年利率：4.9%<br>占比：{{rateC * 100}}%<br>金额：{{amountC}}元</p>
                </div>
            </div>
        </dv-border-box13>
    </div>
</template>

<script>
import {mapActions, mapMutations} from "vuex";
import {message} from "ant-design-vue";

export default {
    name: "recommend",
    data(){
        return {
            backgroundStyle: {
                width: '850px',
                height: '400px',
                backgroundImage: "url(" + require("../../../assets/strategy.jpg") + ")",
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'top',
                backgroundSize: '850px, 400px',
                marginLeft: '120px',
                textAlign: 'left'
            },
            total: 0,
            amountA: 0,
            amountB: 0,
            amountC: 0,
            rateA: 0.5,
            rateB: 0.3,
            rateC: 0.2,
        }
    },
    methods: {
        ...mapMutations([
        ]),
        ...mapActions([
        ]),
        getAmount() {
            if (this.total <= 0) {
                message.info("请输入金额")
            }
            this.amountA = this.total * this.rateA
            this.amountB = this.total * this.rateB
            this.amountC = this.total * this.rateC
        }
    },
}
</script>

<style scoped>

</style>