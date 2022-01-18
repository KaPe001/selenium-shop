pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                echo 'First build'
                git branch: '${branch}', url: 'https://github.com/KaPe001/selenium-shop.git'
                bat 'mvn clean compile'
                echo 'OK compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
                echo 'OK test'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    }
                }
            }
        }
    }
