import axios from 'axios';
import { useState, useEffect } from 'react';
import Chart from 'react-apexcharts'
import { SaleSucess, SaleSum } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
    name: string;
    data: number[];
}

type ChartData = {
    labels: {
        categories: string[];
    };
    series: SeriesData[];
}


const BarChart = () => {

    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "% Sucesso",
                data: []                   
            }
        ]
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/sale-sucess`)
        .then(resp => {
            const data = resp.data as SaleSucess[];
            const myLabels = data.map(x => x.sellerName);
            const mySeriess = data.map(x => round(100 * x.deals / x.visited, 1));
            setChartData({
                labels: {
                    categories: myLabels
                },
                series: [
                    {
                        name: "% Sucesso",
                        data: mySeriess                  
                    }
                ]
            });        
        })
    },[])

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart
            options={{...options, xaxis: chartData.labels}}
            series={chartData.series}
            type="bar"
            height="240"
        />
    );
}
export default BarChart;


