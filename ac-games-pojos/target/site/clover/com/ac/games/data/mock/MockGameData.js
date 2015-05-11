var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":333,"id":2542,"methods":[{"el":105,"sc":3,"sl":105},{"el":164,"sc":3,"sl":113},{"el":168,"sc":3,"sl":166},{"el":172,"sc":3,"sl":170},{"el":176,"sc":3,"sl":174},{"el":180,"sc":3,"sl":178},{"el":184,"sc":3,"sl":182},{"el":188,"sc":3,"sl":186},{"el":192,"sc":3,"sl":190},{"el":196,"sc":3,"sl":194},{"el":200,"sc":3,"sl":198},{"el":204,"sc":3,"sl":202},{"el":208,"sc":3,"sl":206},{"el":212,"sc":3,"sl":210},{"el":216,"sc":3,"sl":214},{"el":220,"sc":3,"sl":218},{"el":224,"sc":3,"sl":222},{"el":228,"sc":3,"sl":226},{"el":232,"sc":3,"sl":230},{"el":236,"sc":3,"sl":234},{"el":240,"sc":3,"sl":238},{"el":244,"sc":3,"sl":242},{"el":248,"sc":3,"sl":246},{"el":252,"sc":3,"sl":250},{"el":256,"sc":3,"sl":254},{"el":260,"sc":3,"sl":258},{"el":264,"sc":3,"sl":262},{"el":268,"sc":3,"sl":266},{"el":272,"sc":3,"sl":270},{"el":276,"sc":3,"sl":274},{"el":280,"sc":4,"sl":278},{"el":284,"sc":3,"sl":282},{"el":288,"sc":3,"sl":286},{"el":292,"sc":3,"sl":290},{"el":296,"sc":3,"sl":294},{"el":300,"sc":3,"sl":298},{"el":304,"sc":3,"sl":302},{"el":308,"sc":3,"sl":306},{"el":312,"sc":3,"sl":310},{"el":316,"sc":3,"sl":314},{"el":320,"sc":3,"sl":318},{"el":324,"sc":3,"sl":322},{"el":328,"sc":3,"sl":326},{"el":332,"sc":3,"sl":330}],"name":"MockGameData","sl":13}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":113},{"sl":258}],"name":"testLCGNetrunnerParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":139},{"sl":259}]},"test_1":{"methods":[{"sl":113},{"sl":294}],"name":"testXWingIG2000Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":148},{"sl":295}]},"test_10":{"methods":[{"sl":113},{"sl":214}],"name":"testBGGMultiNest29663Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":128},{"sl":215}]},"test_11":{"methods":[{"sl":113},{"sl":286}],"name":"testCosmicIncursionParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":146},{"sl":287}]},"test_12":{"methods":[{"sl":113},{"sl":166}],"name":"testMagicTheGatheringParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":116},{"sl":167}]},"test_13":{"methods":[{"sl":113},{"sl":238}],"name":"testNotFoundParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":134},{"sl":239}]},"test_14":{"methods":[{"sl":113},{"sl":182}],"name":"testDCDiceMastersParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":120},{"sl":183}]},"test_15":{"methods":[{"sl":113},{"sl":246}],"name":"testMTG76097Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":136},{"sl":247}]},"test_16":{"methods":[{"sl":113},{"sl":230}],"name":"testCosmicIncursionParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":132},{"sl":231}]},"test_17":{"methods":[{"sl":113},{"sl":250}],"name":"testMTG94687Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":137},{"sl":251}]},"test_18":{"methods":[{"sl":113},{"sl":194}],"name":"testBGG1369Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":123},{"sl":195}]},"test_19":{"methods":[{"sl":113},{"sl":310}],"name":"testMMBoardGamesParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":152},{"sl":311}]},"test_2":{"methods":[{"sl":113},{"sl":274}],"name":"testVideoGamesParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":143},{"sl":275}]},"test_20":{"methods":[{"sl":113},{"sl":266}],"name":"testMiniaturesParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":141},{"sl":267}]},"test_21":{"methods":[{"sl":113},{"sl":314}],"name":"testMMCCGsParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":153},{"sl":315}]},"test_22":{"methods":[{"sl":113},{"sl":330}],"name":"testMMUnknownParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":157},{"sl":331}]},"test_23":{"methods":[{"sl":113},{"sl":318}],"name":"testMMCollectibleMinisParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":154},{"sl":319}]},"test_24":{"methods":[{"sl":113},{"sl":222}],"name":"testAbyssParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":130},{"sl":223}]},"test_25":{"methods":[{"sl":113},{"sl":290}],"name":"testDCDiceMastersParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":147},{"sl":291}]},"test_26":{"methods":[{"sl":113},{"sl":226}],"name":"testCosmicEncounterParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":131},{"sl":227}]},"test_27":{"methods":[{"sl":105},{"sl":113},{"sl":206}],"name":"testBGGNested18460Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":127},{"sl":207}]},"test_28":{"methods":[{"sl":113},{"sl":298}],"name":"testNotFoundParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":149},{"sl":299}]},"test_29":{"methods":[{"sl":113},{"sl":282}],"name":"testCosmicEncounterParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":145},{"sl":283}]},"test_3":{"methods":[{"sl":113},{"sl":242}],"name":"testMTG75069Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":135},{"sl":243}]},"test_30":{"methods":[{"sl":113},{"sl":218}],"name":"testBGG50968Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":129},{"sl":219}]},"test_31":{"methods":[{"sl":113},{"sl":234}],"name":"testDCDiceMastersParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":133},{"sl":235}]},"test_32":{"methods":[{"sl":113},{"sl":254}],"name":"testRPGParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":138},{"sl":255}]},"test_33":{"methods":[{"sl":113},{"sl":326}],"name":"testMMTableTopMinisParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":156},{"sl":327}]},"test_34":{"methods":[{"sl":113},{"sl":262}],"name":"testSuppliesSleevesParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":140},{"sl":263}]},"test_35":{"methods":[{"sl":113},{"sl":210}],"name":"testBGGMultiPartiallParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":126},{"sl":211}]},"test_36":{"methods":[{"sl":113},{"sl":186}],"name":"testNotFoundParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":121},{"sl":187}]},"test_37":{"methods":[{"sl":113},{"sl":302}],"name":"testMM5137Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":150},{"sl":303}]},"test_38":{"methods":[{"sl":113},{"sl":190}],"name":"testBGG53Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":122},{"sl":191}]},"test_39":{"methods":[{"sl":113},{"sl":170}],"name":"testCosmicEncounterParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":117},{"sl":171}]},"test_4":{"methods":[{"sl":113},{"sl":322}],"name":"testMMRPGsParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":155},{"sl":323}]},"test_40":{"methods":[{"sl":113},{"sl":198}],"name":"testBGG1818Parser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":124},{"sl":199}]},"test_41":{"methods":[{"sl":113},{"sl":174}],"name":"testCosmicIncursionParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":118},{"sl":175}]},"test_5":{"methods":[{"sl":113},{"sl":178}],"name":"testAbyssParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":119},{"sl":179}]},"test_6":{"methods":[{"sl":113},{"sl":278}],"name":"testAbyssParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":144},{"sl":279}]},"test_7":{"methods":[{"sl":113},{"sl":306}],"name":"testMMAccessoriesParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":151},{"sl":307}]},"test_8":{"methods":[{"sl":113},{"sl":202}],"name":"testBGGMultiFullParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":125},{"sl":203}]},"test_9":{"methods":[{"sl":113},{"sl":270}],"name":"testGiftCertificateParser","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":142},{"sl":271}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [27], [], [], [], [], [], [], [], [10, 24, 5, 36, 3, 27, 4, 40, 14, 17, 18, 26, 12, 35, 20, 29, 38, 19, 16, 6, 31, 9, 33, 34, 0, 21, 22, 7, 15, 28, 37, 1, 11, 30, 2, 8, 39, 13, 25, 41, 32, 23], [10, 24, 5, 36, 3, 27, 4, 40, 14, 17, 18, 26, 12, 35, 20, 29, 38, 19, 16, 6, 31, 9, 33, 34, 0, 21, 22, 7, 15, 28, 37, 1, 11, 30, 2, 8, 39, 13, 25, 41, 32, 23], [10, 24, 5, 36, 3, 27, 4, 40, 14, 17, 18, 26, 12, 35, 20, 29, 38, 19, 16, 6, 31, 9, 33, 34, 0, 21, 22, 7, 15, 28, 37, 1, 11, 30, 2, 8, 39, 13, 25, 41, 32, 23], [12], [39], [41], [5], [14], [36], [38], [18], [40], [8], [35], [27], [10], [30], [24], [26], [16], [31], [13], [3], [15], [17], [32], [0], [34], [20], [9], [2], [6], [29], [11], [25], [1], [28], [37], [7], [19], [21], [23], [4], [33], [22], [], [], [], [], [], [], [], [], [12], [12], [], [], [39], [39], [], [], [41], [41], [], [], [5], [5], [], [], [14], [14], [], [], [36], [36], [], [], [38], [38], [], [], [18], [18], [], [], [40], [40], [], [], [8], [8], [], [], [27], [27], [], [], [35], [35], [], [], [10], [10], [], [], [30], [30], [], [], [24], [24], [], [], [26], [26], [], [], [16], [16], [], [], [31], [31], [], [], [13], [13], [], [], [3], [3], [], [], [15], [15], [], [], [17], [17], [], [], [32], [32], [], [], [0], [0], [], [], [34], [34], [], [], [20], [20], [], [], [9], [9], [], [], [2], [2], [], [], [6], [6], [], [], [29], [29], [], [], [11], [11], [], [], [25], [25], [], [], [1], [1], [], [], [28], [28], [], [], [37], [37], [], [], [7], [7], [], [], [19], [19], [], [], [21], [21], [], [], [23], [23], [], [], [4], [4], [], [], [33], [33], [], [], [22], [22], [], []]