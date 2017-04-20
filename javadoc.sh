#!/usr/bin/env bash

cd /Users/Andrew/IdeaProjects/util/target/site/apidocs

printf '# Dragovorn Util API Javadocs \n http://util.dragovorn.com' > README.md
printf 'util.dragovorn.com' > CNAME

git init
git remote add origin https://github.com/Dragovorn/util.git
git fetch --depth=1 origin gh-pages
git add --all
git commit -m "Javadoc update"
git merge --no-edit --allow-unrelated-histories -s ours remotes/origin/gh-pages
git push origin master:gh-pages

rm -fr /Users/Andrew/IdeaProjects/util/target/site/apidocs/.git