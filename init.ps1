param (
    [string]$year = $( Get-Date -Format "yyyy" ),
    [string]$day = $( Get-Date -Format "dd" )
)

$day = $day.PadLeft(2, '0')

# Crate input files
New-Item -Name "src/test/resources/$year/day${day}_actual.txt" -ItemType File | Out-Null
New-Item -Name "src/test/resources/$year/day${day}_example.txt" -ItemType File | Out-Null

# Replace version number
((Get-Content -path "build.gradle.kts" -Raw) -Replace "version = ""\d{4}.\d{2}.\d{2}""", "version = ""$year.12.$day""") | Set-Content -NoNewline -Path "build.gradle.kts"

# Create solution
$solutionContent = Get-Content -path "src/main/kotlin/com/dvdmunckhof/aoc/DayXX.kt" -Raw
$solutionContent = $solutionContent -Replace "DayXX", "Day$day" -Replace "package com.dvdmunckhof.aoc","package com.dvdmunckhof.aoc.event$year"
Set-Content -Value $solutionContent -NoNewline -Path "src/main/kotlin/com/dvdmunckhof/aoc/event$year/Day$day.kt"

# Create test
$testContent = Get-Content -path "src/test/kotlin/com/dvdmunckhof/aoc/DayXXTest.kt" -Raw
$testContent = $testContent -Replace "YEAR", $year -Replace "XX", $day -Replace "package com.dvdmunckhof.aoc","package com.dvdmunckhof.aoc.event$year"
Set-Content -Value $testContent -NoNewline -Path "src/test/kotlin/com/dvdmunckhof/aoc/event$year/Day${day}Test.kt"
