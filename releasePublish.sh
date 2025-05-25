#!/bin/bash

./gradlew :sushi-core:assembleRelease :sushi-compose:assembleRelease
./gradlew :sushi-core:publishAllPublicationsToZomatoRepository :sushi-compose:publishAllPublicationsToZomatoRepository