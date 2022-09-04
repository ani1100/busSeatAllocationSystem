<div class="container-fluid" data-ng-controller="BusSearchController">
<div ng-show="!bussearch" class="d-flex justify-content-md-center align-items-center vh-100" style="background-color:#e7feff;">
<h4>No Details Found.Please Try Again Later.</h4>
</div>

<div ng-show="bussearch" style="background-color:#e7feff;">
<h5 class="clear1">&nbsp;</h5>
<div>
	<div class="dtls1">
	     {{busdtlsinfo.busdtls.busnumberplate}}<br>
	     {{busdtlsinfo.busdtls.busname}}
	</div>
	
	<div class="dtls2">  
		<table class="table table-bordered">
	    <thead style="background-color:#0066b2;">
	      <tr>
	        <th class="text-center">Owner Name</th>
	        <th class="text-center">Mobile No</th>
	        <th class="text-center">Email ID</th>
	        <th class="text-center">Endpoint1</th>
	        <th class="text-center">Endpoint2</th>
	      </tr>
	    </thead>
	    <tbody class="text-center" style="background-color:ivory;">
	    <tr>
	       <td>{{busdtlsinfo.busdtls.ownername}}</td>
		   <td>{{busdtlsinfo.busdtls.mobileno}}</td>
		   <td>{{busdtlsinfo.busdtls.emailid}}</td>
		   <td>{{busdtlsinfo.busdtls.endpoint1}}</td>
		   <td>{{busdtlsinfo.busdtls.endpoint2}}</td>
	      </tr>
	    </tbody>
	    </table> 
	</div>  
	<div class="dtls4">
		<table>
		<tr>
		<td data-ng-repeat="m1 in backseatstr"><div class="busstr" style="background-color:{{m1.color}};"></div></td>
		</tr>
		<tr data-ng-repeat="m2 in rowseatstr">
		<td data-ng-repeat="m3 in m2"><div class="busstr" style="background-color:{{m3.color}};"></div></td>
		</tr>
		</table>
	</div>
	
</div>
<h1 class="clear1">&nbsp;</h1>

<div style="margin-left:2%;margin-right:2%">
  <button type="button" class="btn btn-primary" data-target="#busscheduling" data-toggle="pill" id="busch">Bus Scheduling</button>
  <button type="button" class="btn btn-primary" data-target="#completedtrips" data-toggle="pill" ng-click="completedtrips()">Completed Trips</button>
  <button type="button" class="btn btn-primary" data-target="#scheduledtrips" data-toggle="pill" ng-click="schtrips()">Scheduled Trips</button>
</div>
<br>
<div class="tab-content">
        <div id="busscheduling" class="tab-pane fade">
			<jsp:include page="busschedule.jsp" />
		</div>
		<div id="completedtrips" class="tab-pane fade">
			<jsp:include page="completedtrips.jsp" />
		</div>
		<div id="scheduledtrips" class="tab-pane fade">
			<jsp:include page="scheduledtrips.jsp" />
		</div>
</div>
</div>

</div>