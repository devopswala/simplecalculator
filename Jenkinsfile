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
        stage('Docker Build and Push') {
            steps {
                withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
                    sh 'printenv'
                    sh 'docker build -t lsramanjaneyulu/simplecalculatorapp: ""$GIT_COMMT"" .'
                    sh 'docker push lsramanjaneyulu/simplecalculatorapp: ""$GIT_COMMT""'
                }
            }
        }
    }
}