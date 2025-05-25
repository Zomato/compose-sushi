#!/bin/bash

./gradlew :sushi-core:assembleRelease :sushi-compose:assembleRelease
./gradlew :sushi-core:publishAllPublicationsToMavenLocal :sushi-compose:publishAllPublicationsToMavenLocal