<template>
  <div>
      <a-button @click="addProject">添加项目</a-button>
      <a-row :gutter="[6, 2]" style="width: 100%">
          <a-col
              v-for="item in 8"
              :key="item.toString()"
              :span="6"
          >
              <div>
                  <router-link :to="{ name:'dataView', params:{ projectId:1 } }">
                      <a-card hoverable style="width: 300px">
                          <img
                              slot="cover"
                              alt="example"
                              src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                          />
                          <a-card-meta title="Europe Street beat">
                              <template slot="description"> 花旗餐饮行业信用预测项目 </template>
                          </a-card-meta>
                      </a-card>
                  </router-link>
              </div>
          </a-col>
      </a-row>
      <AddProjectModal></AddProjectModal>
  </div>
</template>

<script>

import {mapActions, mapGetters, mapMutations} from "vuex";
import AddProjectModal from "./components/addProjectModal";

export default {
    name: 'review',
    data(){
        return {

        };
    },
    components: {
        AddProjectModal
    },
    computed: {
        ...mapGetters([
        ])
    },
    async mounted() {
        //await this.getProjectCooperation(1)
    },
    methods: {
        ...mapMutations([
            'set_addProjectModalVisible'
        ]),
        ...mapActions([
        ]),
        addProject() {

            this.set_addProjectModalVisible(true)
        }
    }
}
</script>

<style>

</style>