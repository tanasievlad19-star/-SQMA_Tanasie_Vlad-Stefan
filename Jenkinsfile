pipeline {
  agent any

  parameters {
    choice(
      name: 'TEST_TO_RUN',
      choices: ['TestCase1Test', 'TestCase2Test', 'ALL'],
      description: 'Choose which JUnit test class to run'
    )
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Install Maven (if missing)') {
      steps {
        sh '''
          set -eux
          if ! command -v mvn >/dev/null 2>&1; then
            apt-get update -y
            apt-get install -y maven
          fi
          mvn -v
          java -version
        '''
      }
    }

    stage('Run Tests') {
      steps {
        sh '''
          set -eux
          if [ "${TEST_TO_RUN}" = "ALL" ]; then
            mvn -q test
          else
            mvn -q -Dtest=${TEST_TO_RUN} test
          fi
        '''
      }
    }
  }

  post {
    always {
      junit 'target/surefire-reports/*.xml'
    }
  }
}
