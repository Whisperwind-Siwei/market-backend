package com.tongji.market.common.util;

import java.util.List;
/**
 * 计算两个样本数据之间的皮尔逊相关系数
 */
public class PearsonCorrelation {
    public static double getPearsonCorrelationScore(List<Double> x, List<Double> y) {
        if (x.size() != y.size())
            throw new RuntimeException("数据不正确！");
        double[] xData = new double[x.size()];
        double[] yData = new double[x.size()];
        for (int i = 0; i < x.size(); i++) {
            xData[i] = x.get(i);
            yData[i] = y.get(i);
        }
        return getPearsonCorrelationScore(xData,yData);
    }

    public static double getPearsonCorrelationScore(double[] xData, double[] yData) {
        if (xData.length != yData.length)
            throw new RuntimeException("数据不正确！");
        double xMeans;
        double yMeans;
        double numerator = 0;
        double denominator = 0;

        double result = 0;
        xMeans = getMeans(xData);
        yMeans = getMeans(yData);
        numerator = generateNumerator(xData, xMeans, yData, yMeans);
        denominator = generateDenominator(xData, xMeans, yData, yMeans);
        if (denominator == 0) {
            return 0;
        }
        result = numerator / denominator;
        return result;
    }

    private static double generateNumerator(double[] xData, double xMeans, double[] yData, double yMeans) {
        double numerator = 0.0;
        for (int i = 0; i < xData.length; i++) {
            numerator += (xData[i] - xMeans) * (yData[i] - yMeans);
        }
        return numerator;
    }

    private static double generateDenominator(double[] xData, double xMeans, double[] yData, double yMeans) {
        double xSum = 0.0;
        for (int i = 0; i < xData.length; i++) {
            xSum += (xData[i] - xMeans) * (xData[i] - xMeans);
        }
        double ySum = 0.0;
        for (int i = 0; i < yData.length; i++) {
            ySum += (yData[i] - yMeans) * (yData[i] - yMeans);
        }
        return Math.sqrt(xSum) * Math.sqrt(ySum);
    }

    private static double getMeans(double[] datas) {
        double sum = 0.0;
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }
        return sum / datas.length;
    }
}
