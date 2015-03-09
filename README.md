<<<<<<< HEAD
### Ò»¡¢¼ò½é

»ùÓÚiServer£¬Ìá¹©¾ÛºÏ¸÷ÀàÔÚÏßÍßÆ¬µØÍ¼·şÎñµÄÊ¾Àı¡£Èç¹È¸èµØÍ¼¡¢ËÑËÑµØÍ¼¡¢ÌìµØÍ¼µÈ¡£

### ¶ş¡¢À©Õ¹¿ª·¢

Ê¾Àı¶¼ÊÇ»ùÓÚ[ProviderBase](https://github.com/yjjqrqqq/iServer_RemoteTileProviders/blob/master/remotetileproviders/ProviderBase.java) ³éÏóÀàÊµÏÖµÄ¡£ĞèÒªÖ¸¶¨Ò»×éÍßÆ¬µØÍ¼²ÎÊı£¬¾ßÌå²ÎÊıËµÃ÷ÈçÏÂ£º
ĞèÒªÊµÏÖList<RemoteTileMapParameter> remoteTileMapParameters()·½·¨£¬ÓÃ»§ĞèÒªÌá¹©µÚÈı·½ÔÚÏßµØÍ¼µÄµØÍ¼²ÎÊı£¬°üÀ¨ÒÔÏÂ¼¸¸ö£º

<table cellspacing="0px" align="center">
	<col style="width: 15%;">
	<col style="width: 15%;">
	<col style="width: 15%;">
	<col style="width: 55%;">
	<tr>
		<td><b>Ãû³Æ</b></td>
		<td><b>ÀàĞÍ</b></td>
		<td><b>º¬Òå</b></td>
		<td><b>ÊÇ·ñ±ØÒª</b></td>
	</tr>
	<tr>
		<td>mapName</td>
		<td>String</td>
		<td>µØÍ¼Ãû¡£</td>
		<td>ÊÇ</td>
	</tr>
	<tr>
		<td>origin</td>
		<td>Point2D</td>
		<td>ÇĞÆ¬Ô­µã¡£</td>
		<td>ÊÇ</td>
	</tr>
	<tr>
		<td>bounds</td>
		<td>Rectangle2D</td>
		<td>È«Í¼·¶Î§¡£</td>
		<td>ÊÇ</td>
	</tr>
	<tr>
		<td>prjCoordSys</td>
		<td>PrjCoordSys</td>
		<td>µØÍ¼Í¶Ó°¡£</td>
		<td>ÊÇ</td>
	</tr>
	<tr>
		<td>scales</td>
		<td>double[]</td>
		<td>µØÍ¼±ÈÀı³ß¼¯ºÏ¡£</td>
		<td>·ñ</td>
	</tr>
	<tr>
		<td>resolutions</td>
		<td>double[]</td>
		<td>µØÍ¼·Ö±æÂÊ¼¯ºÏ¡£</td>
		<td>·ñ</td>
	</tr>
	<tr>
		<td>remoteTileUrl</td>
		<td>RemoteTileUrl</td>
		<td>Ìá¹©¹¹ÔìÇëÇóÍßÆ¬µÄURLµÄ·½·¨¡£</td>
		<td>ÊÇ</td>
	</tr>
</table>

×¢Òâ£º
<br>1.ÆäÖĞ·Ö±æÂÊ¼¯ºÏºÍ±ÈÀı³ß¼¯ºÏ£¬ÖÁÉÙÉèÖÃÒ»¸ö£¬µ«½¨Òé¶¼ÉèÖÃ¡£</br>
<br>2.SuperMapÄ¬ÈÏÍßÆ¬Öá·½ÏòÎªÓÒÏÂ¡£Èç¹ûÔÚÏßµØÍ¼µÄÍßÆ¬Öá·½ÏòºÍsupermapµÄ²»Í¬µÄ»°,ÄÇÃ´ÍßÆ¬ĞĞÁĞºÅ¿ÉÄÜÉæ¼°µ½×ª»»¡£ÏêÇéÇë²Î¼û[²¿·ÖÍßÆ¬µØÍ¼·şÎñ²ÎÊı½éÉÜ](https://github.com/yjjqrqqq/iServer_RemoteTileProviders/blob/master/%E9%83%A8%E5%88%86%E7%93%A6%E7%89%87%E5%9C%B0%E5%9B%BE%E6%9C%8D%E5%8A%A1%E5%8F%82%E6%95%B0%E4%BB%8B%E7%BB%8D.docx) ºÍÀ©Õ¹Ê¾Àı¡£</br>


### Èı¡¢ÅäÖÃ²¿Êğ

Ïê¼û[ÅäÖÃºÍ²¿Êğ](https://github.com/yjjqrqqq/iServer_RemoteTileProviders/blob/master/%E9%85%8D%E7%BD%AE%E5%92%8C%E9%83%A8%E7%BD%B2.docx) ¡£

### ËÄ¡¢À©Õ¹Ê¾Àı

ÕâÀïÌá¹©ÁËÈı¸öÊ¾Àı£º

1.[¹È¸èÍßÆ¬µØÍ¼·şÎñÊ¾Àı](https://github.com/yjjqrqqq/iServer_RemoteTileProviders/blob/master/remotetileproviders/GoogleMapsMapProvider.java)

![original_THmC_4b6f000174941190](images/GoogleMap.png)

2.[ËÑËÑÍßÆ¬µØÍ¼·şÎñÊ¾Àı](https://github.com/yjjqrqqq/iServer_RemoteTileProviders/blob/master/remotetileproviders/SosoMapProvider.java)
![original_THmC_4b6f000174941190](images/SosoMap.png)

3.[ÌìµØÍ¼ÍßÆ¬µØÍ¼·şÎñÊ¾Àı](https://github.com/yjjqrqqq/iServer_RemoteTileProviders/blob/master/remotetileproviders/TiandituMapProvider.java)
![original_THmC_4b6f000174941190](images/GoogleMap.png)
![original_THmC_4b6f000174941190](images/ChineseAnnotation.png)
![original_THmC_4b6f000174941190](images/EnglishAnnotation.png)
=======
# iServer_RemoteTileProviders
åŸºäºiServerï¼Œæä¾›èšåˆå„ç±»åœ¨çº¿ç“¦ç‰‡åœ°å›¾æœåŠ¡çš„ç¤ºä¾‹ã€‚å¦‚è°·æ­Œåœ°å›¾ã€æœæœåœ°å›¾ã€å¤©åœ°å›¾ç­‰ã€‚
>>>>>>> remotes/iServer_RemoteTileProviders/master
