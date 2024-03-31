pipeline {
    agent any

    stages {
        stage('Build Artifact - Maven') {
            steps {
                sh "mvn clean package -DskipTests=true"
                archive 'target/*.jar'
            }
        }
        stage('Unit Tests - JUnit and JaCoCo'){
            steps {
                sh "mvn test"
            }
            post {
                always {
                    jacoco execPattern: 'target/jacoco.exec'
                }
            }
        }
        stage('Mutation Test - PIT') {
            steps {
                sh "echo START PIT TESTING"
                sh "mvn org.pitest:pitest-maven:mutationCoverage"
            }
        }
        stage('SonarQube - SAST') {
            steps {
                withSonarQubeEnv('sonarqube') {
                   sh "mvn clean verify sonar:sonar -Dsonar.projectKey=simplecalculator -Dsonar.projectName='simplecalculator' -Dsonar.host.url=http://knowledgeacademy.eastus.cloudapp.azure.com:9000 -Dsonar.login=sqp_8da3005f4d513ff0fc9c78b308916bf5fd21d2ab"
                }
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('Docker Build and Push') {
            steps {
                withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
                    sh 'printenv'
                    sh 'docker build -t lsramanjaneyulu/simplecalculatorapp:"$GIT_COMMIT" .'
                    sh 'docker push lsramanjaneyulu/simplecalculatorapp:"$GIT_COMMIT"'
                }
            }
        }
        stage('Kubernetes Deployment - DEV') {
            steps {
                withKubeConfig([credentialsId: 'kubeconfig']) {
                    sh "sed -i 's#replace#lsramanjaneyulu/simplecalculatorapp:${GIT_COMMIT}#g' k8s_deployment_service.yaml"
                    sh "kubectl apply -f k8s_deployment_service.yaml"
                }
            }
        }
    }
}
