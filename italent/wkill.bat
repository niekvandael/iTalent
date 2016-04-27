@ECHO OFF

@echo stopping italent at port 8080

for /f "usebackq tokens=5 delims= " %%i in (`netstat -a -o -n ^| grep 0.0.0.0:8080`) do taskkill /f /pid %%i
