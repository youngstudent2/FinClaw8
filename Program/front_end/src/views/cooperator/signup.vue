<template>
  <div>
      <div style="height:200px">
          <h1 style="font-size:40px">{{projectInfo.projectName}}</h1>
          <p>{{projectInfo.description}}</p>
      </div>
      <a-button type="primary" @click="signUp">
          报名
      </a-button>
  </div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
    
    computed : {
        ...mapGetters([
            'getUnattendedProjectInfoByID',
            'userInfo',
            'attendedProjects'
        ])
    },
    data(){
        return {
            projectID:+this.$route.params.projectID,
            projectInfo:{}
        }
    },
    mounted(){    
        this.projectInfo = this.getUnattendedProjectInfoByID(this.projectID)
    },
    beforeRouteUpdate(to,from,next){
        console.log({to:to.params.projectID,from:from.params.projectID})
        this.projectID = to.params.projectID
        this.projectInfo = this.getUnattendedProjectInfoByID(this.projectID)

        console.log(this.projectID)
        console.log(this.projectInfo.projectName)
    },
    methods:{
        
        ...mapActions([
            "attendProject"
        ]),
        async signUp(){
            const params = {cooperationID:this.userInfo.cooperationID,projectID:this.projectID}
            await this.attendProject(params)
            this.$router.replace({
                name:'cooperatorHome',
            })
        }
    }
}
</script>

<style>

</style>