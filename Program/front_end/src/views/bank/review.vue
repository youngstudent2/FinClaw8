<template>
  <div>
      <a-row :gutter="[12, 18]" style="width: 100%">
          <a-col :span="6">
              <div>
                  <a-card hoverable style="width: 100%; border:2px dashed #eaeaea" @click="addProject">
                      <img
                          slot="cover"
                          alt="example"
                          src="../../assets/addProject.png"
                      />
                      <a-card-meta title="创建项目" style="text-align: center">
                          <template slot="description">{{"点击进入页面"}}</template>
                      </a-card-meta>
                      <template slot="actions" class="ant-card-actions">
                          <div>
                              <a-icon key="add" type="plus" /> 创建
                          </div>
                      </template>
                  </a-card>
              </div>
          </a-col>
          <a-col
              v-for="item in bankProjectList"
              :key="item.toString()"
              :span="6"
          >
              <div>
                  <a-card style="width: 100%">
                      <img
                          slot="cover"
                          alt="example"
                          src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                      />
                      <a-card-meta :title="item.projectName">
                          <template slot="description">{{item.description}}</template>
                      </a-card-meta>
                      <template slot="actions" class="ant-card-actions">
                          <div @click="setProject(item)">
                              <a-icon key="setting" type="setting" /> 管理
                          </div>
                          <div @click="modifyProject(item)">
                              <a-icon key="edit" type="edit" /> 修改
                          </div>
                          <a-popconfirm
                              title="确认删除此项目？"
                              ok-text="是"
                              cancel-text="否"
                              @confirm="deleteProject(item.projectID)"
                          >
                              <a-icon key="delete" type="delete" /> 删除
                          </a-popconfirm>
                      </template>
                  </a-card>
              </div>
          </a-col>
      </a-row>
      <AddProjectModal></AddProjectModal>
      <ModifyProjectModal :modifyData="modifyData"></ModifyProjectModal>
  </div>
</template>

<script>

import {mapActions, mapGetters, mapMutations} from "vuex";
import AddProjectModal from "./components/addProjectModal";
import ModifyProjectModal from "./components/modifyProjectModal"

export default {
    name: 'review',
    data(){
        return {
            modifyData: {}
        };
    },
    components: {
        AddProjectModal,
        ModifyProjectModal
    },
    computed: {
        ...mapGetters([
            'userId',
            'bankProjectList'
        ])
    },
    async mounted() {
        await this.getBankProject(Number(this.userId))
    },
    methods: {
        ...mapMutations([
            'set_addProjectModalVisible',
            'set_currentProject',
            'set_modifyProjectModalVisible'
        ]),
        ...mapActions([
            'getBankProject',
            'deleteProject'
        ]),
        addProject() {
            this.set_addProjectModalVisible(true)
        },
        setProject(data) {
            //console.log(data)
            this.set_currentProject(data)
            this.$router.push({ name:'dataView', params:{ projectId:data.projectID }})
        },
        modifyProject(data) {
            this.modifyData = data
            this.set_modifyProjectModalVisible(true)
        }
    }
}
</script>

<style>

</style>