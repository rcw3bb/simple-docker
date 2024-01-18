@echo off
cd /d %~dp0

REM | Parameter | Description                  |
REM |-----------|------------------------------|
REM | %1        | The docker project directory.   |
REM | %2        | The docker executable.          |
REM | %3*       | The docker command arguments.   |

pushd %1

shift
set docker_cmd=%1

:loop
shift
if (%1)==() goto done
set docker_cmd=%docker_cmd% %1
goto loop
:done

%docker_cmd%
popd