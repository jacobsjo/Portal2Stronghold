# Portal2Stronghold
Searches for Strongholds positioned so that the Portal is generated in a specific Chunk

WARNING: THIS PROGRAM CURRENTLY CONTAINS AN ERROR AND GIVES OUT WRONG RESULTS.

To understand this Program, first watch this Youtube-Video from Crafterdark https://www.youtube.com/watch?v=auT33-1sjm8 .
This tool is not user friendly, it reads a file called log.txt and outputs file called output.txt . The log.txt should be formated
```
  <seed> <protalFilledCount> <ChunkX> <ChunkZ>
```
as it is generated by Azelefs Portal-chunk-finder at https://github.com/Azelef/Portal-chunk-finder . The output.txt file is formated
the same way but contains Stronghold coordinates that generate thease Portals. If there are multiple Strongholds generating the Portal,
there will be multiple lines in the output file. If there is none, the won't be a line in the output file. (both are possible).

As said above this Program sadly isn't quite correct, as the Portal-Room often generates between Chunks (or the Chunks moved by 8) and
I currently don't know how to correctly determine the generating Chunk.
