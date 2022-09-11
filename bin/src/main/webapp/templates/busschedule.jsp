<div>
<div style="margin-left:2%;margin-right:2%;background-color:Ivory;">
<br><br>
<form>
<table>
<tbody>
<tr>
<td style="width:5%"></td>
<td style="width:10%">
<div class="form-group">
<label>Start Point</label>
<select ng-model="busdtlsinfo.startpoint" ng-options="x for x in places" ng-change="change1('start')" class="form-control" style="width:200px"></select>
</div>
</td>
<td style="width:10%">
<div class="form-group">
<label>End Point</label>
<select ng-model="busdtlsinfo.endpoint" ng-options="x for x in places" ng-change="change1('end')" class="form-control" style="width:200px"></select>
</div> 
</td>
<td style="width:10%">
<div class="form-group">
<label>Departure Date</label>
<input type="date" class="form-control" style="width:200px" data-ng-model="busdtlsinfo.depdate" >
</div> 
</td>
</tbody>
<tbody>
<td style="width:5%"></td>
<td style="width:10%">
<div class="form-group">
<label>Departure Time</label>
<input type="time" class="form-control" style="width:200px" data-ng-model="busdtlsinfo.deptime" id="deptime">
</div> 
</td>
<td style="width:10%">
<div class="form-group">
<label>Arrival Date</label>
<input type="date" class="form-control" style="width:200px" data-ng-model="busdtlsinfo.arrdate" >
</div>
</td>
<td style="width:10%">
<div class="form-group">
<label>Arrival Time</label>
<input type="time" class="form-control" style="width:200px" data-ng-model="busdtlsinfo.arrtime" id="arrtime">
</div>
</td>
</tbody>
</table>
<br>
<div class="d-flex justify-content-center">
<button type="button" ng-click="schedulebus()" class="btn btn-success">Submit</button>
&nbsp;
<button type="button" ng-click="resetbus()"class="btn btn-success">Reset</button>
</div>
</form>
<br>
</div>
<br><br>
</div>