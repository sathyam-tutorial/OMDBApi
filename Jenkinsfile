#!groovy

pipeline {
    agent any
    currentBuild.result = "SUCCESS"
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
    catch (err) {
        currentBuild.result = "FAILURE"

            mail body: "Mobile project build error is here: ${env.BUILD_URL}" ,
            from: 'jenkinsci@gmail.com',
            replyTo: 'techsathya77@gmail.com',
            subject: 'Mobile Project build failed',
            to: 'techsathya77@gmail.com'
        throw err
    }
}