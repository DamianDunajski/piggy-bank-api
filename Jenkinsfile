#!groovy
//file:noinspection GroovyAssignabilityCheck

pipeline {
  agent {
    kubernetes {
      yaml '''
        apiVersion: v1
        kind: Pod
        spec:
          containers:
          - name: maven
            image: maven:3.9
            command:
              - sleep
            args:
              - 99d
            volumeMounts:
              - mountPath: /root/.m2/repository
                name: maven-repo
          volumes:
            - name: maven-repo
              persistentVolumeClaim:
                claimName: maven-repo
      '''
      defaultContainer 'maven'
    }
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Compile') {
      steps {
        sh 'mvn -B clean compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn -B test'
      }
    }

    stage('Build image') {
      steps {
        sh 'mvn -B -DskipTests spring-boot:build-image'
      }
    }
  }
}
