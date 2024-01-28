node("ci-node") {
    stage("Checkout") {
        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MdTcn/SimpleProject.git']])
    }

    stage("Unit Tests") {
        sh "chmod 777 ./mvnw"
        sh "./mvnw test"
    }

    stage("Build") {
        sh "./mvnw -DskipTests package"
    }

    stage("build docker image"){
        sh "sudo docker build -t simpleproject ."
    }

    stage("Push docker image to registry"){
        sh "docker tag simpleproject mdycn/simpleproject:1.0"
        withCredentials([usernamePassword(credentialsId: 'mdycn', passwordVariable: 'password', usernameVariable: 'username')]) {
            sh "sudo docker login -u $username -p $password"
            sh "sudo docker push mdycn/simpleproject:1.0"
            sh "sudo docker rmi mdycn/simpleproject:1.0"
            sh "sudo docker rmi simpleproject:1.0"
            stash include: 'docker-compose.yml', name: 'utils'
        }
    }
}