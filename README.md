### 一、简介

iServer_RemoteTileProviders是帮助用户基于iServer扩展开发对接第三方在线地图服务提供者的解决方案。

### 二、扩展开发

用户可以继承[ProviderBase](https://github.com/cxk910204/test3/blob/master/iServer_RemoteTileProviders/src/remotetileproviders/ProviderBase.java) 抽象类，来聚合第三方的在线地图服务。
需要实现List<RemoteTileMapParameter> remoteTileMapParameters()方法，用户需要提供第三方在线地图的地图参数，包括以下几个：

<table cellspacing="0px" align="center">
	<col style="width: 20%;">
	<col style="width: 20%;">
	<col style="width: 60%;">
	<tr>
		<td><b>名称</b></td>
		<td><b>类型</b></td>
		<td><b>含义</b></td>
	</tr>
	<tr>
		<td>mapName</td>
		<td>String</td>
		<td>地图名。</td>
	</tr>
	<tr>
		<td>origin</td>
		<td>Point2D</td>
		<td>切片原点。</td>
	</tr>
	<tr>
		<td>bounds</td>
		<td>Rectangle2D</td>
		<td>全图范围。</td>
	</tr>
	<tr>
		<td>prjCoordSys</td>
		<td>PrjCoordSys</td>
		<td>地图投影。</td>
	</tr>
	<tr>
		<td>scales</td>
		<td>double[]</td>
		<td>地图比例尺集合。</td>
	</tr>
	<tr>
		<td>resolutions</td>
		<td>double[]</td>
		<td>地图分辨率集合。</td>
	</tr>
	<tr>
		<td>remoteTileUrl</td>
		<td>RemoteTileUrl</td>
		<td>接口变量，用于构造请求瓦片的URL。</td>
	</tr>
</table>

注意：其中分辨率集合和比例尺集合，用户可任意设置一个，但建议用户都设置，如果只设置其中一个，默认通过TileTool类中提供的转换方法resolutionToScale或scaleToResolution转换得到另一个参数。除此以外的参数均为必要参数，用户都需要设置。
SuperMap默认的坐标系为X轴正方向向右,Y轴正方向向下。如果第三方在线地图的默认坐标系和supermap默认的坐标系不同的话,那么瓦片行列号可能涉及到转换。详情请参见[部分第三方地图服务参数介绍](https://github.com/cxk910204/test3/blob/master/%E9%83%A8%E5%88%86%E7%AC%AC%E4%B8%89%E6%96%B9%E5%9C%B0%E5%9B%BE%E6%9C%8D%E5%8A%A1%E5%8F%82%E6%95%B0%E4%BB%8B%E7%BB%8D.docx) 和扩展示例。

### 三、配置部署

详见[配置和部署](https://github.com/cxk910204/test3/blob/master/%E9%85%8D%E7%BD%AE%E5%92%8C%E9%83%A8%E7%BD%B2.docx)

### 四、扩展示例

这里提供了三个示例：

1.[谷歌地图服务示例](https://github.com/cxk910204/test3/blob/master/iServer_RemoteTileProviders/src/remotetileproviders/GoogleMapsMapProvider.java)

2.[搜搜地图服务示例](https://github.com/cxk910204/test3/blob/master/iServer_RemoteTileProviders/src/remotetileproviders/SosoMapProvider.java)

3.[天地图地图服务示例](https://github.com/cxk910204/test3/blob/master/iServer_RemoteTileProviders/src/remotetileproviders/TiandituMapProvider.java)

