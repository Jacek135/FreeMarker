<!DOCTYPE html>
<html>
<head><title> FreeMarker Spring MVC Hello World</title>

    <style>
        body, input {
            font-family: Calibri, Arial;
            margin: 0px;
            padding: 0px;
        }
        #header h2 {
            color: white;
            background-color: #3275A8;
            height: 50px;
            padding: 5px 0 0 5px;
            font-size: 20px;
        }

        .datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
        .datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertica l-align:middle;color:#444444}
        .datatable tr {border:1px solid #888}
        .datatable tr.odd {background-color:#eee}
        .datatable td {padding:2px;border:1px solid #888}
        #content { padding 5px; margin: 5px; text-align: center}
        fieldset { width: 300px; padding: 5px; margin-bottom: 0px; }
        legend { font-weight: bold; }
    </style>
</head>
<body>
<div id="header">
    <H2>
        FreeMarker Spring MVC Hello World
    </H2>
</div>

<div id="content">

    <fieldset>
        <legend>Add Car</legend>
        <form name="carDto" action="add" method="post" modelAttribute="carDto">
            Make : <input type="text" name="make" />	<br/>
            Model: <input type="text" name="model" />	<br/>
            Year  : <input type="text" name="year" />	<br/>
            <input type="submit" value="   Save   " />
        </form>
    </fieldset>

    <br/>
    <table class="datatable">
        <tr>
            <th>Make</th>  <th>Model</th>  <th>Year</th>
        </tr>
        <#list model["carList"] as carDto>
            <tr>
                <td>${carDto.make}</td> <td>${carDto.model}</td> <td>${carDto.year}</td>
            </tr>
        </#list>
    </table>

    <input type="button" value="Search" onclick="location.href='/search'"/>

</div>
</body>
</html>