#!/bin/bash
cd /home/kavia/workspace/code-generation/shopease-mobile-c4059039/shopping_app_frontend
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

