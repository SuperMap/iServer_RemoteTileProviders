### һ�����

����iServer���ṩ�ۺϸ���������Ƭ��ͼ�����ʾ������ȸ��ͼ�����ѵ�ͼ�����ͼ�ȡ�

### ������չ����

ʾ�����ǻ���[ProviderBase](https://github.com/yjjqrqqq/iServer_RemoteTileProviders/blob/master/remotetileproviders/ProviderBase.java) ������ʵ�ֵġ���Ҫָ��һ����Ƭ��ͼ�������������˵�����£�
��Ҫʵ��remoteTileMapParameters()�������û���Ҫ�ṩ���������ߵ�ͼ�ĵ�ͼ�������������¼�����

<table cellspacing="0px" align="center">
	<col style="width: 15%;">
	<col style="width: 15%;">
	<col style="width: 15%;">
	<col style="width: 55%;">
	<tr>
		<td><b>����</b></td>
		<td><b>����</b></td>
		<td><b>����</b></td>
		<td><b>�Ƿ��Ҫ</b></td>
	</tr>
	<tr>
		<td>mapName</td>
		<td>String</td>
		<td>��ͼ����</td>
		<td>��</td>
	</tr>
	<tr>
		<td>origin</td>
		<td>Point2D</td>
		<td>��Ƭԭ�㡣</td>
		<td>��</td>
	</tr>
	<tr>
		<td>bounds</td>
		<td>Rectangle2D</td>
		<td>ȫͼ��Χ��</td>
		<td>��</td>
	</tr>
	<tr>
		<td>prjCoordSys</td>
		<td>PrjCoordSys</td>
		<td>��ͼͶӰ��</td>
		<td>��</td>
	</tr>
	<tr>
		<td>scales</td>
		<td>double[]</td>
		<td>��ͼ�����߼��ϡ�</td>
		<td>��</td>
	</tr>
	<tr>
		<td>resolutions</td>
		<td>double[]</td>
		<td>��ͼ�ֱ��ʼ��ϡ�</td>
		<td>��</td>
	</tr>
	<tr>
		<td>remoteTileUrl</td>
		<td>RemoteTileUrl</td>
		<td>�ṩ����������Ƭ��URL�ķ�����</td>
		<td>��</td>
	</tr>
</table>

ע�⣺
<br>1.���зֱ��ʼ��Ϻͱ����߼��ϣ���������һ���������鶼���á�</br>
<br>2.SuperMapĬ����Ƭ�᷽��Ϊ���¡�������ߵ�ͼ����Ƭ�᷽���supermap�Ĳ�ͬ�Ļ�,��ô��Ƭ���кſ����漰��ת����������μ�[������Ƭ��ͼ�����������](https://github.com/SuperMap/iServer_RemoteTileProviders/blob/master/%E9%83%A8%E5%88%86%E7%93%A6%E7%89%87%E5%9C%B0%E5%9B%BE%E6%9C%8D%E5%8A%A1%E5%8F%82%E6%95%B0%E4%BB%8B%E7%BB%8D.docx) ����չʾ����</br>


### �������ò���

���[���úͲ���](https://github.com/SuperMap/iServer_RemoteTileProviders/blob/master/%E9%85%8D%E7%BD%AE%E5%92%8C%E9%83%A8%E7%BD%B2.docx) ��

### �ġ���չʾ��

�����ṩ������ʾ����

1.[�ȸ���Ƭ��ͼ����ʾ��](https://github.com/SuperMap/iServer_RemoteTileProviders/blob/master/remotetileproviders/GoogleMapsMapProvider.java)

![original_THmC_4b6f000174941190](images/GoogleMap.png)

2.[������Ƭ��ͼ����ʾ��](https://github.com/SuperMap/iServer_RemoteTileProviders/blob/master/remotetileproviders/SosoMapProvider.java)
![original_THmC_4b6f000174941190](images/SosoMap.png)

3.[���ͼ��Ƭ��ͼ����ʾ��](https://github.com/SuperMap/iServer_RemoteTileProviders/blob/master/remotetileproviders/TiandituMapProvider.java)
![original_THmC_4b6f000174941190](images/BaseMap.png)
![original_THmC_4b6f000174941190](images/ChineseAnnotation.png)
![original_THmC_4b6f000174941190](images/EnglishAnnotation.png)

### �塢��Eclipse��ʹ�ù���

1.����Java��Ŀ��File��Import��ѡ��General�µ�Existing Projects into Workspace��ѡ����Ŀ�ļ��С�Finish��ɵ��롣
<br>
2.�����Ŀ������jar��������Ŀ���Ƶ���Ҽ���Build Path��Configure Build Path����Order and Exportѡ���¹�ѡJRE System Library����Librariesѡ���µ��Add External JARs��ťѡ��%SuperMapiServer_HOME%/webapps/iserver/WEB-INF/lib/�µ�����jar����

