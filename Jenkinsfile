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
                    junit 'target/surefire-reports/*.xml'
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
    }
}