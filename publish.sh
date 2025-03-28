#!/bin/bash

./gradlew :sushi-core:assembleDebug :sushi-core:assembleRelease :sushi-compose:assembleDebug :sushi-compose:assembleRelease
./gradlew :sushi-core:publishAllPublicationsToZomatoRepository :sushi-compose:publishAllPublicationsToZomatoRepository