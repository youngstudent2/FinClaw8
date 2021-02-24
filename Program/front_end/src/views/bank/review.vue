<template>
  <div>
      <a-row :gutter="[12, 18]" style="width: 100%">
          <a-col :span="6">
              <div>
                  <a-card hoverable style="width: 100%; border:1px dashed #cccccc" @click="addProject">
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
                          :src="imageUrls[item.projectID % imageUrls.length]"
                      />
                      <div class="mask"><em>@FinClaw8</em></div>
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
            modifyData: {},
            imageUrls: [
                'https://image.tianyancha.com/2de12f1756eb457b85755c69313e8007.jpg@!hotNews_f_273x171',
                'https://image.tianyancha.com/521dd0e0891d49938cae2986d468afb0.jpg@!hotNews_f_273x171',
                'https://image.tianyancha.com/ac34744af238437e941dbb4b9302fa6c.jpg@!hotNews_f_273x171',
                'https://image.tianyancha.com/fdd85d9ae7194cc79b34a1020c629b54.jpg@!hotNews_f_273x171',
                'https://image.tianyancha.com/3d6b1e3578ab4cc484d21464dab96b77.jpg@!hotNews_f_273x171',
                'https://image.tianyancha.com/4957e956ec8e4c36927879efb407e15a.jpg@!hotNews_f_273x171',
                'https://image.tianyancha.com/6d0d305d68d94c36a8345e57319188d0.jpg@!hotNews_f_273x171',
                'https://image.tianyancha.com/4886cf4361054ff1a71ebb2b9c62c1db.jpg@!hotNews_f_273x171',
            ]
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
.mask {
    width: 80px;
    height: 30px;
    line-height: 30px;
    background-color: rgba(255, 255, 255, 0.6);
    border-radius: 30px;
    position: absolute;
    margin-top: -60px;
    margin-left: 225px;
    font-weight: bold;
}
</style>