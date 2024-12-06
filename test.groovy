pipeline {
    agent any

    stages {
        stage('Get Source Code') {
            steps {
                git credentialsId: 'a5499089-a6f6-46bb-890f-c98802efbca2', url: 'https://github.com/Mahfuzur15/Myalice-24-task.git'
                echo 'Hello World'
            }
        }
        stage('Build Code')
        {
            steps
            {
            bat script: 'mvn compile'
            }
        }
         stage('Run Test')
        {
            steps
            {
            bat script: 'mvn test -Dbrowser=localchrome'
            }
        }
        stage('Publish Report')
        {
            steps{
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '', reportFiles: 'target/surefire-reports/Extent*.html', reportName: 'HTML Report Pipeline', reportTitles: '', useWrapperFileDirectly: true])
            }
        }
    }
}
