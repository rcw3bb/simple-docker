#!/usr/bin/env sh

cd `dirname $1`

#| Parameter | Description                  |
#|-----------|------------------------------|
#| $1        | The docker project directory.   |
#| $2        | The docker executable.          |
#| $3*       | The docker command arguments.   |

orig_dir=`pwd`
cd $1

shift
docker_cmd=$1

shift

while [ "$1" != "" ] 
do
	docker_cmd="$docker_cmd $1"
	shift
done

$docker_cmd

cd $orig_dir


