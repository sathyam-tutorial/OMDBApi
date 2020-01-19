#!groovy

pipeline {
    agent any
    try {
        stages {
            stage('Checkout') {
                steps {
                    triggers {
                        cron(env.BRANCH_NAME == 'customer-mobile-feature' ? 'H */12 * * *' : '')
                      }
                    checkout scm
                }
            }

            stage('Gradle Build') {
                withCredentials([usernamePassword(credentialsId: 'MyArtifactory', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    steps {
                        sh '''
                             set +x
                             echo "Running Gradle Build"
                             ./gradle -b build.gradle -PUSERNAME=$USERNAME -PPASSWORD=$PASSWORD jar artifactoryPublish
                        '''
                    }
                }
            }
        }
    }
}